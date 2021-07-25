package com.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Node("film")
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @Property("ad")
    private String ad;

    @Property("yonetmen")
    private String yonetmen;

}
