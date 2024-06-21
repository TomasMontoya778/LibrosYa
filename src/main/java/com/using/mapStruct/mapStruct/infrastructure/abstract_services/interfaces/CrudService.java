package com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
    public void delete(ID id);

    public RS getById(ID id);

    public RS create(RQ request);

    public RS update(ID id, RQ request);

    public Page<RS> getAll(int page, int size);
}
