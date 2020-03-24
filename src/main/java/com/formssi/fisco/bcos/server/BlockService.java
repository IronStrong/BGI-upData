package com.formssi.fisco.bcos.server;




import com.formssi.fisco.bcos.dto.Block;
import org.fisco.bcos.web3j.protocol.core.methods.response.BcosBlock;

import java.math.BigInteger;

public interface BlockService {

	int getBlockHigh() throws Exception;


	//Block getBlockInfo(BigInteger blockNumber) throws Exception;
}
