import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { enviroment } from './enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = enviroment.apiBaseurl;

  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiUrl}/employees`);

  }

  public addEmployee(emplpoyee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiUrl}/employees`, emplpoyee);

  }
  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiUrl}/employees/update`, employee);

  }
  public deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/employees/${employeeId}`);

  }
}
