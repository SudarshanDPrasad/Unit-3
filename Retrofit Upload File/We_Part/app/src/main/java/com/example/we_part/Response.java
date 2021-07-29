package com.example.we_part;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Response implements Serializable {

	@SerializedName("data")
	private Data data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("status")
	private int status;

	public Data getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	public int getStatus(){
		return status;
	}
}