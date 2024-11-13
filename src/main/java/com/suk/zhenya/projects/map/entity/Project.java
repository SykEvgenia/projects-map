package com.suk.zhenya.projects.map.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    private ObjectId id;

    @Field("name")
    private String name;

    @Field("webAddress")
    private String webAddress;
}
