package com.transactionalmanagement.service;



import com.transactionalmanagement.exception.PersonNotFoundException;
import com.transactionalmanagement.model.Person;
import com.transactionalmanagement.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
@RequiredArgsConstructor
//@Transactioanl Spring, sınıf düzeyinde açıklamayı, bu sınıfın @Transactional ile açıklama eklemediğimiz tüm public yöntemlerine uygular .
public class PersonService {

    private final PersonRepository personRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (this.personRepository.count() == 0) {
            IntStream.range(0, 100)
                    .mapToObj(this::create)
                    .map(this.personRepository::save)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }

    }

    private Person create(int i) {
        return Person.builder()
                .name(i+".Person")
                .surname("person"+i)
                .salary(2780)
                .birthDate(LocalDate.of(1987,05,15))
                .credit(new BigDecimal("300.000"))
                .build();
    }


    // Sadece Verilen istisna(PersonNotFoundException) için işlemi geri alır
    @Transactional(rollbackFor = { PersonNotFoundException.class })
    public Person getRollbackFor(int id){
        Optional<Person> person =this.personRepository.findById(id);
        if (person.isPresent())
            return person.get();
        else {
            this.personRepository.save(Person.builder()
                    .name(id+"Cano")
                    .surname("Can"+id)
                    .salary(100)
                    .birthDate(LocalDate.of(2000, 01, 01))
                    .credit(new BigDecimal("300.000"))
                    .build());
            throw new PersonNotFoundException(id + " İdli kişi bulunamadı Yeni Kayıtta Yapılamadı");
        }

    }

    // Sadece Verilen istisna(PersonNotFoundException) hariç diğer tüm istisnalar için işlemi geri alır
    // Yani Rollback yapılması istenmeyen classlar belirtilir
    @Transactional(noRollbackFor = { PersonNotFoundException.class })
    public Person getNoRollbackFor(int id){
        Optional<Person> person =this.personRepository.findById(id);
        if (person.isPresent())
            return person.get();
        else
            this.personRepository.save(Person.builder()
                    .name(id+"Cano")
                    .surname("Can"+id)
                    .salary(100)
                    .birthDate(LocalDate.of(2000, 01, 01))
                    .credit(new BigDecimal("300.000"))
                    .build());
        throw  new PersonNotFoundException(id+" idli kişi bulunamadı ama Yeni Kayıttta Yapıldı");

    }

    //REQUIRES_NEW Aktif bir transaction var ise bunu bekletir(Suspend), ve yeni bir transaction açar
    //READ_UNCOMMITTED(1.Seviye) Bu izolasyona sahip bir işlem, diğer eşzamanlı işlemlerin kaydedilmemiş(UNCOMMIT) verilerini okur
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation= Isolation.READ_UNCOMMITTED)
    public Person savePerson(Person kisi) {
        return this.personRepository.save(kisi);
    }

    //NOT_SUPPORTED Eğer bir transaction var ise o transaction u kullanır .Yok ise transaction’sız çalışır. Yeni bir transaction da açmaz
    //READ_COMMITTED(2.Seviye) Bu seviyede sadece COMMIT durumundaki transanction verisi okunabilir. Veri tabanına kayıt atan bir transactiondaki veri,
    // commit olduktan sonra eş zamanda çalışan diğer transaction tarafından bu dataya ulaşılır.Bu izolasyona sahip bir işlem, kirli okumaları önler.
    @Transactional(propagation = Propagation.NOT_SUPPORTED,isolation= Isolation.READ_COMMITTED)
    public Person updatePerson(int id, Person kisi){
        return this.personRepository.save(kisi);
    }


    //REQUIRED Eğer mevcutta bir transaction var ise yeni bir transaction açmadan bu transactionu kullanır,Eğer transaction yoksa yeni bir transaction açar.
    //READ_UNCOMMITTED Bu izolasyona sahip bir işlem, diğer eşzamanlı işlemlerin kaydedilmemiş(UNCOMMIT) verilerini okur
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation= Isolation.READ_UNCOMMITTED)
    public Person getPerson(int id){
        return this.personRepository.findById(id).get();
    }

    //REQUIRED Eğer mevcutta bir transaction var ise yeni bir transaction açmadan bu transactionu kullanır,Eğer transaction yoksa yeni bir transaction açar.
    //REPEATABLE_READ(3.Seviye) ,kirli ve tekrarlanamayan okumaları önler. Bu nedenle, eşzamanlı işlemlerde taahhüt edilmemiş değişikliklerden etkilenmeyiz.
    //Yani eş zamanlı iki transactionda select yapan transactionın iki farklı dataya erişimi olmaz.
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation= Isolation.REPEATABLE_READ)
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }
    //REQUIRED Eğer mevcutta bir transaction var ise yeni bir transaction açmadan bu transactionu kullanır,Eğer transaction yoksa yeni bir transaction açar.
    //SERIALIZABLE(4.Seviye),Bu seviyede hiç bir anomali gerçekleşmez ama transaction concurrency(eş zamanlılık) durumuna da izin vermez ve en az performanslı olan seviyedir
    @Transactional(propagation = Propagation.REQUIRED,isolation= Isolation.SERIALIZABLE)
    public void deletePerson(int id) {
       this.personRepository.deleteById(id);
    }
}
