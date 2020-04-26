
  package com.cg.sprint2.payment.dto;
  
 import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
  
  @Entity
  
  @Table(name="transactiondetails")
  public class TransactionHistory
  {
	  @Id
	  @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="transidseq")
	  @SequenceGenerator(sequenceName="transactionid_seq",allocationSize=1,name="transidseq")
	  @Column(name="Transid")
	  int transactionId;
	  String status;
	  double amount;
	  String mobileno;
	  String name;
	  Date dateoftrans;
	  
	  
	  
	  
  
  
  }
 