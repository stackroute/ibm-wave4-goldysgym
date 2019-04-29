package com.stackroute.springbootneo4jCRUD.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Session")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Session {
    @Id
    private Long id;
    private String name;
    private String imageUrl;


    public Session(Long id, String name,String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl=imageUrl;
    }

    public Session() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
