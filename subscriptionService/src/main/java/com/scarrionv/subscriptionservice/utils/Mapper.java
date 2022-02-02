package com.scarrionv.subscriptionservice.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Utility class to map one Object to another one.
 */
public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private Mapper() {

    }

    /**
     * Map a list of objects into another list of other given type
     *
     * @param source Source list to be mapped
     * @param targetClass The class of the object for the target list
     * @param <S> Type of Source object
     * @param <T> Type of target object
     *
     * @return The target list mapped from the source list
     */
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return Optional.ofNullable(source)
                .orElse(new ArrayList<>())
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * Map a object into another object of other given type
     *
     * @param source Source object to be mapped
     * @param targetClass The class of the target object
     * @param <S> Type of Source object
     * @param <T> Type of target object
     * @return The target object mapped from the soure object
     */
    public static <S, T> T map(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }

}
