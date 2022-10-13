package p.lodz.pl.nbd.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Embeddable
public class Locker {

    private boolean empty = true;
    private String password;

    public boolean checkPassword(final String passwd) {
        return passwd.equals(password);
    }
}
