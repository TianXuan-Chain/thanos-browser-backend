pragma solidity ^0.4.25;


interface IERC165 {
    function supportsInterface(bytes4 interfaceId) external view returns (bool);
}

interface TokenInterface {
    /**
     * 获取token全局元信息
     */
    function getTokenMeta() public constant returns (string, string, string, string, uint256);
}


contract NFTToken is IERC165, TokenInterface {

    //tokenId 限制的总数量, 0为不限量
    uint256 public totalLimitSupply;
}
