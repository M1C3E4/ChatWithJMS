package com.example.ChatWithJMS.adapters.durable;

import com.example.ChatWithJMS.adapters.durable.mappers.JpaDurablePeopleMapper;
import com.example.ChatWithJMS.adapters.durable.mappers.JpeDurableDuctMapper;
import com.example.ChatWithJMS.adapters.durable.repository.JpaDuctRepo;
import lombok.RequiredArgsConstructor;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaDuctRepoAdapter {

    private final JpaDuctRepo jpaDuctRepo;
    private final JpeDurableDuctMapper jpeDurableDuctMapper;
    private final JpaDurablePeopleMapper jpaDurablePeopleMapper;

}
