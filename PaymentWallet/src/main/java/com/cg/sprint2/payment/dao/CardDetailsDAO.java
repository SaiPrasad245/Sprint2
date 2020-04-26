package com.cg.sprint2.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.sprint2.payment.dto.CardDetails;

@Repository
public interface CardDetailsDAO  extends JpaRepository<CardDetails,String>
{
		
}
