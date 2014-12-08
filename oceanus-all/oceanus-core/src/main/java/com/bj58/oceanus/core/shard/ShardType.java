/*
 *  Copyright Beijing 58 Information Technology Co.,Ltd.
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.bj58.oceanus.core.shard;


/**
 * sharding 类型
 * 
 * @author Service Platform Architecture Team (spat@58.com)
 */
public enum ShardType {
	/**
	 * 按数据库进行划分,多库多表
	 */
	BY_DATABASE("BY-DATABASE"),
	/**
	 * 一个schema下面多个表
	 */
	BY_TABLE("BY-TABLE"),
	BY_DATABASE_TABLE("BY-DATABASE-TABLE"),
	NO_SHARD("NO-SHARD");

	private String input;
	
	private ShardType(String input) {
		this.input = input;
	}
	
	public static ShardType parse(String input) {
		for(ShardType shardType : values()){
			if(shardType.input.equals(input) 
					|| shardType.name().equals(input)){
				
				return shardType;
			}
		}
		throw new IllegalArgumentException("Unsupport ShardType, input string : " + input);
	}
}
