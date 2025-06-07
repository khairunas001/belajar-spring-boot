package com.java.spring_dasar.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFoo {

    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider){
        foos = objectProvider.stream().collect(Collectors.toList());
        //.stream() akan mengembalikan semua yang ada pada list foos
        // .collect(...) digunakan untuk mengumpulkan elemen dari stream ke dalam struktur data.
        // Collectors.toList() akan mengumpulkan elemen stream menjadi List<Foo>.
    }

}
