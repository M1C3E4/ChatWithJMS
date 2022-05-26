package com.example.ChatWithJMS.adapters.durable;

import com.example.ChatWithJMS.adapters.durable.mappers.JpaDurablePeopleMapper;
import com.example.ChatWithJMS.adapters.durable.repository.JpaPeopleRepo;
import com.example.ChatWithJMS.domain.People;
import com.example.ChatWithJMS.ports.PeopleRepo;
import lombok.RequiredArgsConstructor;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaPeopleRepoAdapter implements PeopleRepo {

    private final JpaDurablePeopleMapper jpaDurablePeopleMapper;
    private final JpaPeopleRepo jpaPeopleRepo;

    @Override
    public void addPeople(People people) {
        var peopleEntity = jpaDurablePeopleMapper.toEntity(people);
        jpaPeopleRepo.save(peopleEntity);
    }

    @Override
    public void deletePeopleOfChatByName(String name) {
        jpaPeopleRepo.remove(name);
    }

    @Override
    public Optional<People> getChatPeopleByName(String name) {
        var peopleEntityOptional = jpaPeopleRepo.getByName(name);
        return peopleEntityOptional.map(jpaDurablePeopleMapper::toDomain);
    }
}
