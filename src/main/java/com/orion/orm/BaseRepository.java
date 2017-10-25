package com.orion.orm;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by LLC on 2017/10/22.
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends MongoRepository<T,ID>{}
