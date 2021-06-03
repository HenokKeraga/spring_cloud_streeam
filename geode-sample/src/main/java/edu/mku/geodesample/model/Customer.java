package edu.mku.geodesample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Region("customer")
@Builder
public class Customer  implements PdxSerializable {

    @Id
    private String name;
    private List<String> list;

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("name",this.name).markIdentityField("name").writeObject("list",list);
    }

    @Override
    public void fromData(PdxReader reader) {
        this.name=reader.readString("name");
        this.list=(List)reader.readObject("list");
    }
}
