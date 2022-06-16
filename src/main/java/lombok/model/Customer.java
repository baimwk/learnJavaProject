package lombok.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.Set;

@Value
@Builder(toBuilder = true)
public class Customer {
    @NonNull
    String customerId;

    @NonNull
    String email;

    @Singular
    Set<String> favoriteFoods;
}
