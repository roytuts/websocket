import { OnInit, Component } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import $ from 'jquery';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  url = 'http://localhost:8080/websocket'
  client: any;
  
  ngOnInit() {
	this.title.setTitle('Angular Spring Websocket');
  }
  
  constructor(private title: Title){
    this.connection();
  }
  
  connection(){
    let ws = new SockJS(this.url);
    this.client = Stomp.over(ws);
    let that: any = this;
	
    this.client.connect({}, function(frame: any) {
      that.client.subscribe("/topic/greeting", (message: any) => {
        if(message.body) {
		  $(".msg").html(message.body)
        }
      });
    });
  }
  
}
