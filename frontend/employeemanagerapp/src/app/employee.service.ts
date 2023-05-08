import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = '';

  constructor(private http: HttpClient) { }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiUrl}/employee`);

  }

  public addEmployees(emplpoyee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiUrl}/employee`, emplpoyee);

  }
  public updateEmployees(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiUrl}/employee/update`, employee);

  }
  public deleteEmployees(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/employee/${employeeId}`);

  }
}
