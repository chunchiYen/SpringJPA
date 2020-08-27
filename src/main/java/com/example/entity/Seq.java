package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seq database table.
 * 
 */
@Entity
@Table(name="seq")
@NamedQuery(name="Seq.findAll", query="SELECT s FROM Seq s")
public class Seq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=30)
	private String itemName;

	private int item_Seq;

	@Column(length=6)
	private String seqYear;

	public Seq() {
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItem_Seq() {
		return this.item_Seq;
	}

	public void setItem_Seq(int item_Seq) {
		this.item_Seq = item_Seq;
	}

	public String getSeqYear() {
		return this.seqYear;
	}

	public void setSeqYear(String seqYear) {
		this.seqYear = seqYear;
	}

}