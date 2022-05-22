package com.example.ChatWithJMS.adapters.durable;

import com.example.ChatWithJMS.adapters.durable.entity.PeopleEntity;
import com.example.ChatWithJMS.adapters.durable.mappers.JpaDurableInformationMapper;
import com.example.ChatWithJMS.adapters.durable.mappers.JpeDurableDuctMapper;
import com.example.ChatWithJMS.adapters.durable.repository.JpaInformationRepo;
import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.domain.Information;
import com.example.ChatWithJMS.ports.InformationRepo;
import lombok.RequiredArgsConstructor;
import lombok.var;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaInformationRepoAdapter implements InformationRepo {

    private final JpaInformationRepo jpaInformationRepo;
    private final JpaDurableInformationMapper jpaDurableInformationMapper;
    private final JpeDurableDuctMapper jpeDurableDuctMapper;

    @Override
    public void sendInformation(Information information, Duct duct) {
        var informationEntity = jpaDurableInformationMapper.toEntity(information);
        var ductEntity = jpeDurableDuctMapper.toEntity(duct);
        var peopleList = ductEntity.getDuctPeoples().stream().map(PeopleEntity::getPeopleName).toList();
        informationEntity.getAccessPeopleList().addAll(peopleList);
        jpaInformationRepo.sendInformation(informationEntity, ductEntity);


    }
}
