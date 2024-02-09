package tr.com.FedoMarket;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UrunServis {

	
	private List<Urun> urunListesi = new ArrayList<>();
	
	
	public String urunStokArtir (Urun urun) {
		
		
		if(urunListesi.size() == 0) {
			
			urun.urunAdedi++;
			urunListesi.add(urun);
			
		} else {
			
						
			for (Urun u : urunListesi) {
				
				if(u.urunAdi.equals(urun.urunAdi)) {
					
					u.urunAdedi++;
					
					return "{\"mesaj\": \"Ürünün stok değeri 1 artırıldı.\"}";
					
				}
				
			}
			
			
			urun.urunAdedi++;
			urunListesi.add(urun);
			
		}
		
		
		return "{\"mesaj\": \"Ürününüz stoklara başarıyla eklendi.\"}";
	}  

	
	public List<Urun> urunStokListele() {
		
		return urunListesi;
		
	}
	
	
	public String urunStokAzalt (String urunAdi) {
		
		
		if(urunListesi.size() != 0 ) {
			
		
		for (Urun u : urunListesi) {
			
			
			if(u.urunAdi.equals(urunAdi)) {
				
				if(u.urunAdedi != 0) {
					u.urunAdedi--;
					
					
					if(u.urunAdedi == 0) { 
						urunListesi.remove(u);
						return "{\"mesaj\": \"Ürün stoğu bittiği için stoklardan kaldırıldı.\"}";
					}
					
					return "{\"mesaj\": \"1 adet ürün stoktan azaltıldı.\"}";
				} 
	
			}     
				
		}
		
		     return "{\"mesaj\": \"Stoklarda boyle bir ürün bulunmamaktadır.\"}";
		
		}else { 
		
			return "{\"mesaj\": \"Stoklarda ürün bulunmamaktadır.\"}";
			
		}
	}
	
}