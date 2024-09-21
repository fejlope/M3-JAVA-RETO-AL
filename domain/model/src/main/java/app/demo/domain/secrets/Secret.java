package app.demo.domain.secrets;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Secret {

    private final String user;

    private final String password;

    private final String host;

    private final String dbName;

    private final String port;
}
