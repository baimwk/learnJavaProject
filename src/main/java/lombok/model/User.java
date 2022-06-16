package lombok.model;

import lombok.Data;
import lombok.NonNull;

//@Data = @ToString + @EqualsAndHashCode + @Getter / @Setter + @RequiredArgsConstructor
@Data
public class User {
    @NonNull
    private String userId;
    @NonNull
    private String email;
}
