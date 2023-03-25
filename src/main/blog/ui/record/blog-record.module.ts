import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BlogRecordComponent } from './blog-record.component';
import { BlogRecordService } from './blog-record.service';

@NgModule({
  declarations: [BlogRecordComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [BlogRecordService]
})
export class BlogRecordModule { }