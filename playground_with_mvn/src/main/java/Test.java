import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.SignedJWT;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Optional;
public class Test {

    public Test() throws NoSuchAlgorithmException, InvalidKeySpecException, JOSEException {
        run();
    }

    private static final String privateKey = "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";
    private static final String publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAsYbIuk6z00JahztK//zWlyh8An+xCoGYAw1OMVvQ6fNhSI+TThqagfe6QMyM/82vSKCLTnCvZ2rfd9h0JhTeMwi3pYeYVAfs/7YvIvFrYDv0Zx2uJweJ+vwgRDiTfUATJ/V7LMsrZltWfKDS5g1W8OgSfJpwSmvLkAnRfXGQ6kQK9JYR6kxwarfl/Ux4qGXYUgbhznCgMIrc3aMf6IRSdXScgLs7mRIoj66YOjeNLiNWK3PGn6R9Dz6ekWrLd3Vdpuxcpf+WmCnbg+fcMPS0LnDFQ/et6gAX+0hLyDCQm0Fl/FJ+IZ5jm/7/48OSsbSw14a6Dz243+KLk3pKvDZReujXBrMWtg5T11YdpHGJBmsg+2/ptGUfksSrvV4v8olJ+giF+NakaHBiquwt/V0Kz5SwTR7hmGDGhPV95Y0mtUKtDyLbW1WyNfOtQdUt6FrYA/GHDw/XX8X/VwnWidALvVAondBnrHzFoiY4wv06qy2CSuuokeB3O9UNUq/7thTzC1di8gEcz2meU06t3I+3uBpNFL4n/khXKCNDBFQNy8cesjT7Smv9tmj3NAVfNMp5HQAXg8fAVUIOc96L8abcrgoaYXAiMstAygx2eMLoBaxZmZPT40L8LrM5DfYxQ5MoXnwv9g5ZjvJx+fu+QHIAc0JVgyRz9hNEro8iDV3uX2MCAwEAAQ==";

    public void run() throws NoSuchAlgorithmException, InvalidKeySpecException, JOSEException {
        // Prepare
        final KeyFactory kf = KeyFactory.getInstance("RSA");
        System.out.println("Key Factory Instance : " + kf.toString() + "\n");

        final KeySpec publicKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        System.out.println("Public Key Spec : " + publicKeySpec.toString() + "\n");

        final PublicKey publicKey = kf.generatePublic(publicKeySpec);
        System.out.println("Public Key : " + publicKey + "\n");

        final RSAKey rsaKey = new RSAKey.Builder((RSAPublicKey) publicKey)
                .build();
        System.out.println("RSA Key : " + rsaKey + "\n");

        System.out.println(rsaKey.toPublicKey());

        /*
        // Run
        final AsymmetricJwtAuthentication asymmetricJwtAuthentication =
                new AsymmetricJwtAuthentication(privateKey, JWSAlgorithm.RS512, "feedzai-internal", "feedzai");
        final Optional<String> jwtOpt = AuthenticationUtils.generateAsymmetricJwt("RSA", asymmetricJwtAuthentication, 30000);

        // Test
        final RSAPublicKey rsaPublicKey = rsaKey.toRSAPublicKey();
        final SignedJWT signedJWT = SignedJWT.parse(jwtOpt.get());
        final JWSVerifier verifier = new RSASSAVerifier(rsaPublicKey);
        */

    }
}

