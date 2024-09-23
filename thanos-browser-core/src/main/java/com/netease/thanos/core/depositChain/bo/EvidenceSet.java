package com.netease.thanos.core.depositChain.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.netease.thanos.core.depositChain.bo.NvEvidenceChainDefineBo.FuncNameDefine;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidenceChain;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidenceChainUser;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointCorporation;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointObject;
import com.netease.thanos.core.depositChain.entity.NvDepositEvidencePointUser;

import lombok.Data;
import lombok.Setter;

/**
 * 证据集合操作类
 * 
 * @author longyubo 2020年12月23日 上午10:22:02
 **/

public class EvidenceSet {
	
	private String name;			
	
	// 索引
	// txHash索引
	private HashMap<String/* txHash */, EvidenceWrapper> txHashIndex = new HashMap<>();

	// hash索引
	private HashMap<String/* hash */, EvidenceWrapper> hashIndex = new HashMap<>();

	// 函数名索引
	private HashMap<String/* funcName */, FuncNameDefine> funcIndex = new HashMap<>();


	//证据链上的用户
	List<NvDepositEvidenceChainUser> chainedUser;
	Map<String /*username*/, NvDepositEvidenceChainUser> usermap;
	
	
	// 原始数据
	private NvDepositEvidenceChain evidenceChain;
	
	private List<NvDepositEvidencePointCorporation> corporPoint = new ArrayList<NvDepositEvidencePointCorporation>();
	private List<NvDepositEvidencePointUser> userPoint = new ArrayList<NvDepositEvidencePointUser>();
	private List<NvDepositEvidencePointObject> objectPoint = new ArrayList<NvDepositEvidencePointObject>();
	// 函数名称
	private List<FuncNameDefine> funcNames = new ArrayList<NvEvidenceChainDefineBo.FuncNameDefine>();

	
	// 包装类
	private List<EvidenceWrapper> allEvidences = new ArrayList<>();
	
	
	public Map<String/*user*/, List<EvidenceWrapper>> getEvidencePointGroupByUser(){
		return allEvidences.stream().collect(Collectors.groupingBy(EvidenceWrapper::getUser));
	}
	
	public void setUserOnEvidenceChain(	List<NvDepositEvidenceChainUser> userOnChain) {
		this.chainedUser=userOnChain;
		LinkedHashMap<String,NvDepositEvidenceChainUser> hashmap=new LinkedHashMap<String, NvDepositEvidenceChainUser>();
		for (NvDepositEvidenceChainUser u : userOnChain) {
			hashmap.put(u.getRelateUser(), u); 
		}
		usermap=hashmap;
		
	}
	
	public Map<String /*username*/, NvDepositEvidenceChainUser> getUsermap(){
		return usermap;
	}
	public EvidenceWrapper queryHashIndex(String hash) {
		return hashIndex.get(hash);
	}
	
	public EvidenceWrapper queryTxHash(String txHash) {
		return txHashIndex.get(txHash);
	}
	
	public List<String> getAllHash(){
		Set<String> keySet = hashIndex.keySet();
		return Lists.newArrayList(keySet);
	}
	
	public int getAllEvidencePointSize() {
		return allEvidences.size();
	}

	public void setEvidenceChain(NvDepositEvidenceChain ec) {
		this.evidenceChain=ec;
	}
	
	public NvDepositEvidenceChain getEvidenceChain() {
		return this.evidenceChain;
	}
	
	public void addFuncNameDefineList(List<FuncNameDefine> funcNames) {
		this.funcNames.addAll(funcNames);
		for (FuncNameDefine funcNameDefine : funcNames) {
			funcIndex.put(funcNameDefine.getFunName(), funcNameDefine);
		}
	}

	public void addObjectEvidencePoint(List<NvDepositEvidencePointObject> objectEvi) {
		this.objectPoint.addAll(objectEvi);

		// 放入对应索引
		// 交易hash
		for (NvDepositEvidencePointObject object : objectEvi) {
			EvidenceWrapper ew = new EvidenceWrapper();
			ew.setObj(object);
			String txHash = ew.getTxHash();
			txHashIndex.put(txHash, ew);

			List<HashWrapper> partParamHash = ew.getPartParamHash();
			if (!CollectionUtils.isEmpty(partParamHash)) {
				for (HashWrapper hw : partParamHash) {
					String hashValue = hw.getFileHash();
					hashIndex.put(hashValue, ew);
				}
			}
			hashIndex.put(ew.getAllParamHash(), ew);

			allEvidences.add(ew);
		}
	}

	public void addUserEvidencePoint(List<NvDepositEvidencePointUser> userEvi) {
		this.userPoint.addAll(userEvi);

		// 放入对应索引
		// 交易hash
		for (NvDepositEvidencePointUser user : userEvi) {
			EvidenceWrapper ew = new EvidenceWrapper();
			ew.setUser(user);
			String txHash = ew.getTxHash();
			txHashIndex.put(txHash, ew);

			List<HashWrapper> partParamHash = ew.getPartParamHash();
			if (!CollectionUtils.isEmpty(partParamHash)) {
				for (HashWrapper hw : partParamHash) {
					String hashValue = hw.getFileHash();
					hashIndex.put(hashValue, ew);
				}
			}
			hashIndex.put(ew.getAllParamHash(), ew);
			allEvidences.add(ew);
		}
	}

	public void addCorporationEvidencePoint(List<NvDepositEvidencePointCorporation> evidences) {
		this.corporPoint.addAll(evidences);

		// 放入对应索引
		// 交易hash
		for (NvDepositEvidencePointCorporation corp : evidences) {
			EvidenceWrapper ew = new EvidenceWrapper();
			ew.setCorporation(corp);
			String txHash = ew.getTxHash();
			txHashIndex.put(txHash, ew);

			List<HashWrapper> partParamHash = ew.getPartParamHash();
			if (!CollectionUtils.isEmpty(partParamHash)) {
				for (HashWrapper hw : partParamHash) {
					String hashValue = hw.getFileHash();
					hashIndex.put(hashValue, ew);
				}
			}
			hashIndex.put(ew.getAllParamHash(), ew);
			allEvidences.add(ew);
		}
	}
	
	public String queryFuncChineseName(String funcName) {
		  FuncNameDefine funcNameDefine = funcIndex.get(funcName);
		  if(funcNameDefine!=null) {
			  return funcNameDefine.getChineseName();
		  }
		  return null;
	}

	@Setter
	public static class EvidenceWrapper {

		// must be one of them
		NvDepositEvidencePointCorporation corporation;
		NvDepositEvidencePointUser user;
		NvDepositEvidencePointObject obj;

		// 获取这个证据点关联的用户
		public String getUser() {
			if (corporation != null) {
				return corporation.getTxDataRelateUser();
			}
			if (user != null) {
				return user.getTxDataRelateUser();
			}
			if (obj != null) {
				return obj.getTxDataRelateUser();
			}
			return null;
		}

		/**
		 * 需要判空
		 * 
		 * @return
		 */
		public String getTxHash() {
			if (corporation != null) {
				return corporation.getTxHash();
			}
			if (user != null) {
				return user.getTxHash();
			}
			if (obj != null) {
				return obj.getTxHash();
			}
			return null;
		}

		public List<HashWrapper> getPartParamHash() {
			String json = null;

			if (corporation != null) {
				json = corporation.getTxDataPartparamsHashjson();
			}
			if (user != null) {
				json = user.getTxDataPartparamsHashjson();
			}
			if (obj != null) {
				json = obj.getTxDataPartparamsHashjson();
			}

			if (json != null) {
				return JSON.parseArray(json, HashWrapper.class);
			} else {
				return new ArrayList<>();
			}

		}
		
		public  String getAllParamHash() {
			String hash = null;

			if (corporation != null) {
				hash = corporation.getTxDataAllparamsHash();
			}
			if (user != null) {
				hash = user.getTxDataAllparamsHash();
			}
			if (obj != null) {
				hash = obj.getTxDataAllparamsHash();
			}

			return hash;

		}
		

		/**
		 * 需要判空
		 * 
		 * @return
		 */
		public String getFuncName() {
			if (corporation != null) {
				return corporation.getTxDataFuncName();
			}
			if (user != null) {
				return user.getTxDataFuncName();
			}
			if (obj != null) {
				return obj.getTxDataFuncName();
			}
			return null;
		}
		
		
		public Long getTime() {
			if (corporation != null) {
				return corporation.getTxTime().getTime();
			}
			if (user != null) {
				return user.getTxTime().getTime();
			}
			if (obj != null) {
				return obj.getTxTime().getTime();
			}
			return null;
		}

		public TxDataMark getTxDataMark() {
			if(obj!=null && obj.getTxDataRemark()!=null) {
				String dm=obj.getTxDataRemark();
				TxDataMark parseObject = JSON.parseObject(dm,TxDataMark.class);
				return parseObject;
			}
			return null;
		}
		
	}
	


	
	
	public EvidenceWrapper getLastSignedMainFileEvidence() {
		
		Optional<EvidenceWrapper> findFirst = allEvidences.stream().filter(e->{
			List<HashWrapper> partParamHash = e.getPartParamHash();
			for (HashWrapper hashWrapper : partParamHash) {
				if (hashWrapper.isMainFile()) {
					 return true;
				}
			}
			return false; 
		}).filter(e->e.getTxDataMark()!=null && e.getTxDataMark().isEnd()).findFirst();
		
		return findFirst.isPresent()?findFirst.get():null;
	}
	
	

	@Data
	public static class HashWrapper {
	 
		    private String fileName;
		    private String fileHash;
		    private String fileField;
		    private boolean mainFile;
		 

	}
	
	@Data
	public static class TxDataMark  {
		boolean end;
	}

}
