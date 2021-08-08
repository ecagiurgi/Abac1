import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PlanetComponent} from './planet-component/planet-component.component';
import {TabMenuModule} from "primeng/tabmenu";
import {PlanetService} from "./service/planet.service";
import {HttpClientModule} from "@angular/common/http";
import {DataViewModule} from "primeng/dataview";
import {TagModule} from "primeng/tag";
import {SplitButtonModule} from "primeng/splitbutton";
import {ConfirmationService, MenuItem, MessageService} from "primeng/api";
import {MenuModule} from "primeng/menu";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MessagesModule} from "primeng/messages";
import {ButtonModule} from "primeng/button";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import {FormsModule} from "@angular/forms";
import {DropdownModule} from "primeng/dropdown";
import { CreatePlanetComponent } from './create-planet/create-planet.component';
import {RippleModule} from "primeng/ripple";
import {RadioButtonModule} from "primeng/radiobutton";
import {CheckboxModule} from "primeng/checkbox";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {TextFieldModule} from "@angular/cdk/text-field";
import {TooltipModule} from "primeng/tooltip";


@NgModule({
  declarations: [
    AppComponent,
    PlanetComponent,
    CreatePlanetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TabMenuModule,
    DataViewModule,
    TagModule,
    InputTextareaModule,
    SplitButtonModule,
    MenuModule,
    BrowserAnimationsModule,
    SplitButtonModule,
    ConfirmDialogModule,
    ButtonModule,
    MessagesModule,
    DropdownModule,
    InputTextModule,
    CheckboxModule,
    ButtonModule,
    RadioButtonModule,
    RippleModule,
    FormsModule,
    TextFieldModule,
    TooltipModule

  ],
  providers: [
    PlanetService, MessageService, ConfirmationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

