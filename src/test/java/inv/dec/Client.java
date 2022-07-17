package inv.dec;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data  //generates getter and setter
@AllArgsConstructor  //constructor

public class Client {

   private String firm_name;
   private String firm_town;
   private String firm_addr;
   private Boolean firm_is_reg_vat;
   private String firm_mol;
}
