package com.formssi.fisco.bcos.server;

import com.formssi.fisco.bcos.dto.BGIReturnJson;




public interface UpChainData {
    BGIReturnJson UpChain(String[] args);
}
