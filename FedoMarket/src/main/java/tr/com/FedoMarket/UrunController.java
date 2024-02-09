package tr.com.FedoMarket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/urun")
public class UrunController {


	@Autowired
	public UrunServis urunServis;
	
	
	@PostMapping("/urunEkle")
	public ResponseEntity<String> stokArtir(@RequestBody Urun urun) {
			
			return  ResponseEntity.ok(urunServis.urunStokArtir(urun));
			
		}
		

	@GetMapping("/urunleriListele")
	public List<Urun> stokListele (){
		
		return urunServis.urunStokListele();
	
	}
	

	@DeleteMapping("/urunAzalt")
	public ResponseEntity<String> stokAzalt(@RequestParam String urunAdi) {
		
		return ResponseEntity.ok(urunServis.urunStokAzalt(urunAdi));
		
	}
	
}