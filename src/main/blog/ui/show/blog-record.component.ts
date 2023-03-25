import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-blog-record',
  templateUrl: './blog-record.component.html',
  styleUrls: ['./blog-record.component.css']
})
export class BlogRecordComponent implements OnInit {

  records: any[];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<any[]>('http://localhost:8080/records')
      .subscribe(records => {
        this.records = records;
      });
  }
}
