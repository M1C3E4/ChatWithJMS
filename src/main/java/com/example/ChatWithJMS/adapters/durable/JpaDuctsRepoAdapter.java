package com.example.ChatWithJMS.adapters.durable;

import com.example.ChatWithJMS.adapters.durable.mappers.JpeDurableDuctMapper;
import com.example.ChatWithJMS.adapters.durable.repository.JpaDuctsRepo;
import com.example.ChatWithJMS.domain.Duct;
import com.example.ChatWithJMS.ports.DuctsRepo;
import lombok.RequiredArgsConstructor;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class JpaDuctsRepoAdapter implements DuctsRepo {

    private final JpaDuctsRepo jpaDuctsRepo;
    private final JpeDurableDuctMapper jpeDurableDuctMapper;

    @Override
    public void addDuct(Duct duct) {
        var ductEntity = jpeDurableDuctMapper.toEntity(duct);
        jpaDuctsRepo.addDuct(ductEntity);
    }

    @Override
    public void removeDuct(String duct) {
        jpaDuctsRepo.removeDuct(duct);

    }

    @Override
    public List<Duct> getDuctList() {
        var ductEntity = jpaDuctsRepo.getDucts();
        return ductEntity.stream().map(jpeDurableDuctMapper::toDomain).toList();
    }

    @Override
    public Optional<Duct> getDuctByName(String ductName) {
        var ductEntityOptional = jpaDuctsRepo.getByName(ductName);
        return ductEntityOptional.map(jpeDurableDuctMapper::toDomain);
    }
}
