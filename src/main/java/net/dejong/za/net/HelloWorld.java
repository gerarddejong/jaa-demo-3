package net.dejong.za.net;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class HelloWorld {

    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4300000);

    public static void main(String[] args) throws Exception {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        String publicKey = "0xe4702603f6aa91cc532a8cc4ace1b3a3f760f6e7"; // from ganache-cli
        String privateKey = "0xda6c8944c8cf563114ec91d164b8c41d3e4f46ba9704e213c4e668923cdc7589";

        Credentials credentials = Credentials.create(privateKey, publicKey);

        Greeter contract = Greeter.load("0xd65c0c1966cdeb31a884c2b1402439c9a36834af",
                web3,
                credentials,
                GAS_PRICE, GAS_LIMIT);

        String greeting = contract.greet().send();
        System.out.println(greeting);
    }
}