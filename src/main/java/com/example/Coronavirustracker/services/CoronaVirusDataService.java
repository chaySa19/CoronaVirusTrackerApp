package com.example.Coronavirustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.Coronavirustracker.models.locationState;

@Service
public class CoronaVirusDataService {
	
	private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";
	
	private List<locationState> allStats= new ArrayList<locationState>();
	//Province_State
	// Country_Region
	//UID, iso2, iso3, code3, FIPS, Admin2, Province_State, Country_Region, Lat, Long_, Combined_Key 9/23/22
	@PostConstruct
//	@Scheduled(cron="* * * * * *")//rb this methode once everyDay
	public void fetchVirusData() throws IOException, InterruptedException {
		HttpClient client= HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().
				uri(URI.create(VIRUS_DATA_URL)).build();
		 
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		 List<locationState> Stats= new ArrayList<locationState>();

		
		StringReader csvBodyReader= new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			locationState lS = new locationState();
			lS.setState( record.get("Province_State"));
			lS.setCountry( record.get("Country_Region"));
			lS.setLatestTotalCases(Integer.parseInt(record.get(record.size()-1)));
			
			

			
			Stats.add(lS);		   
		}
		allStats=Stats;
	}
	public List<locationState> getAllStats() {
		return allStats;
	}
	public void setAllStats(List<locationState> allStats) {
		this.allStats = allStats;
	}

}
