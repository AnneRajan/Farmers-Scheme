import { Injectable } from '@angular/core';
import { Admin } from '../model/admin.model';

@Injectable({
    providedIn : 'root'

})

export class AdminDataService{
    public admin : Admin[];

    constructor(){
        this.admin=[];
    }
}