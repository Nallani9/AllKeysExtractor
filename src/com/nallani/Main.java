package com.nallani;

public class Main {

    public static void main(String[] args) {

      /*  AESDecrypt decrypt = new AESDecrypt(); //decrypt AES
        String out = decrypt.decrypt("FEnLmwZN%2B1Qnlgm0t18dszimeMed4ZsCxBgzaS6n1ZmM4NEjO72Vfq4ZwFSarEiN8sqpmHInS6Y%2F3tKrUh0C%2Fo9YjMeflfBnIsux0aXiSaWTw8BR8phYjUZXi67KKSb%2FK5Myyoh570eVlNeP4MejLa3AEGUVCxUfVs5Zz6TNH2rUUfFoqWmH%2BoFh9VBG9a1Ur%2Ff5%2BYAG3PoeCokW%2FnQLIqOiKBIRElRdGfebJmLDa0B7IqthnZTBlCkuo96yTgva5Ft5kaXnLuS8vKpe4VtocC%2FeC80xIFn4nmsm%2BX2YvVpGQV7QfsKj%2FDf%2Fffl5sYekIi5VUS0HGXAzY52gGVmsow%3D%3D%7C0oONZvERVQ7ZNaoDwOtisDpjBL0Hze%2FJlJgKyFH%2FPsPFgvR6UUP7BpNRAVGVHLd2Jx7SCwedfoMIupmdCTMwRURKKv01iNN8S%2B1bAsxxix6vps31qL1AR%2Bpdb1oosZYV5wtsxJQ%2B8ukzVGGV4xIeSex8ALPxHN9ch1rDqoRtQkQ%3D");
        System.out.println(out);*/
        /*AESDecrypt decrypt = new AESDecrypt();
        String encAttributes = "ASwUuAfWDP%252F7FIwxDilGMl%252BxJp3WtHt10ELEu44CBLVPzqdRNbNkZcxz6JEVjlJPVuP620DEw4EkmmzZaad9be4Fxlhoi26vOfdE%252BlOjFA2RuZFdE7nBQ1D3zFgVeCIwwCfWd%252Blqo17oWynjWWHOyQC%252BFzMNUxJs14T5QCvWqztK%252F2w4Kx3A5e84sfN8%252FfZjXCUva3i4gvTB4vR0MBAHjeSMQKP4Au5Bivb%252F7m8r5sdISEu%252FCpPP92Sgt%252BdRkKoJ0grilMKfw4BEQhdpz2sSw6gLgOaEt2QHvdk68U2BDUI0IRbY8PpYbpRuqXzlJUDmjHxvtjbUAJLTO%252BsLHhqOZQ%253D%253D%257CUMe4zsskppNtxf0JGwsjyvQXfk0CoTv6MyUxRvZK6O7Uoi16zPg6Zk1PCoZSOKiHL1bK9bfIiQED1l0LCqhWjpi4cLM%252BJbmCSM8Yla6GcI4b11gjfRxHIgVauAw0dHxJuNEcEJZvvCAqwNKeVL%252B5qRHJpgoMPdQrncpvLa66RtU%253D";
        System.out.println(decrypt.decrypt(encAttributes));*/


        System.out.println("AES-Key");
        ExtractKeysFromJCEKS certsCode = new ExtractKeysFromJCEKS();//(AES public & private key)
        certsCode.getAESKeysInfoProd();
        System.out.println("=============================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");

        System.out.println("saml private & public key");
        ExtractKeysFromJCEKS certs = new ExtractKeysFromJCEKS();//(saml private key & public key)
        certs.getSAMLKeysInfoProd();

    }
}
