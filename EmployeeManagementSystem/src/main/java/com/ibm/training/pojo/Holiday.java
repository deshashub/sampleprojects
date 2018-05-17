package com.ibm.training.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Holiday {

	 	private int e_id; 
		private int id;
		private int no_of_leaves;
		private String status;
		
		public Holiday() {}
		
		public int getE_id() {
			return e_id;
		}
		public void setE_id(int e_id) {
			this.e_id = e_id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setNo_of_leaves(int no_of_leaves) {
			this.no_of_leaves = no_of_leaves;
		}

		public int getNo_of_leaves() {
			return no_of_leaves;
		}
		
}