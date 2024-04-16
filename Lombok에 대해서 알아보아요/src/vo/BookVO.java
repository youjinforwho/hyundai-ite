package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	
	@NonNull
	private String bisbn;
	@NonNull
	private String btitle;
	private int bprice;
	private String bauthor;

}
