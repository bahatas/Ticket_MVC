package com.ticket_mvc.implementation;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapService<ID,T> {

    protected Map<ID,T> map = new HashMap<>();

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

}

