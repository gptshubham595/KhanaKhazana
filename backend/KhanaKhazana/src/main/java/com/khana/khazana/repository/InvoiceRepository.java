package com.khana.khazana.repository;

import com.khana.khazana.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query(value = "select * from invoice where user_id = ?1 order by timestamp desc", nativeQuery = true)
    List<Invoice> findAllByuserIdOrderBytimestampDesc(long userId);
}
