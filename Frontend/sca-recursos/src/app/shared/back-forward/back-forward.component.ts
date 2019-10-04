import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'sca-back-forward',
  templateUrl: './back-forward.component.html',
  styleUrls: ['./back-forward.component.css']
})
export class BackForwardComponent implements OnInit {

  constructor(private location: Location) { }

  ngOnInit() {
  }

  backPage() {
    this.location.back();
  }

  forwardPage() {
    this.location.forward();
  }

}
