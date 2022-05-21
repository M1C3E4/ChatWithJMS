package com.example.ChatWithJMS.adapters.durable.repository;

import com.example.ChatWithJMS.adapters.durable.mappers.JpaDurablePeopleMapper;
import com.example.ChatWithJMS.adapters.durable.mappers.JpeDurableDuctMapper;
import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.ports.DuctRepo;
import lombok.RequiredArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaDuctRepo implements DuctRepo {

    private final JpaDuctRepo jpaDuctRepo;
    private final JpeDurableDuctMapper jpeDurableDuctMapper;
    private final JpaDurablePeopleMapper jpaDurablePeopleMapper;


    @Override
    public void addPeopleFromDuctIntoDuct(People people, Duct duct) {

    }

    @Override
    public void deleteDuctPeople(People people, Duct duct) {

    }

    @Override
    public List<People> getDuctPeople(Duct duct) {
        return null;
    }
}
