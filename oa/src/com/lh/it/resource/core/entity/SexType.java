package com.lh.it.resource.core.entity;
  public  enum SexType{
		
		Man("男"),Woman("女"),Unknown("未知");
		
		 private final String info;
		 
        private SexType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
	}