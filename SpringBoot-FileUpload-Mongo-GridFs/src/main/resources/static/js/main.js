'use strict'

let uploadForm = document.querySelector("#fileUploadForm");
let uploadFormInput = document.querySelector("#fileUploadInput");
let downloadAndDeleteFile = document.querySelector("#downloadAndDeleteFileUrl");


function uploadFile(file) {
    let formData = new FormData();
    formData.append("file", file);

    let req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/file/upload")

    req.onload = function () {
        let response = req.responseText;

        if (response !== null) {
            let downloadUrl = "http://localhost:8080/file/download/" + response;
            let deleteUrl = "http://localhost:8080/file/delete/" + response;
            downloadAndDeleteFile.innerHTML = '<p>Dosya Başarıyla yüklendi. <br/> <a href="' + downloadUrl + '" target="_parent">İndir</a>'+
                '<a href="' + deleteUrl + '" target="_self" id="`+response+`" style="margin-left: 10px" >Sil</a></p>';
            downloadAndDeleteFile.style.display = "block";
        } else {
            alert("Error Occured! No file returned");
        }
    }

    req.send(formData);
}

uploadForm.addEventListener('submit', function (event) {
    const files = uploadFormInput.files;

    if (files.length !== 0 ) {
        uploadFile(files[0]);
        event.preventDefault();
    } else {
        alert('Lütfen bir dosya seçin')
    }

}, true);