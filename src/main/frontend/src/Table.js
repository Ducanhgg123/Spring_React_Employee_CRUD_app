import React from 'react';
import { useState, useEffect, useContext } from 'react';
import Row from './Row';
import { Link } from 'react-router-dom';

export const EmployeeContext = React.createContext();
function Table() {
  const [employees, setEmployees] = useState([]);
  const getEmployees = async () => {
    const response = await fetch('http://localhost:8080/apis/employees');

    const data = await response.json();
    setEmployees(data);
  };

  const removeEmployee = (id) => {
    const requestOptions = {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(id),
    };
    fetch(`http://localhost:8080/apis/employees/${id}`, requestOptions).then(
      () => getEmployees()
    );
  };

  useEffect(() => {
    getEmployees();
  }, []);
  return (
    <div>
      <EmployeeContext.Provider value={{ removeEmployee }}>
        <Link to='/form'>
          <button>Add Employee</button>
        </Link>
        <table>
          <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Email</td>
            <td>Action</td>
          </tr>
          {employees.map((employee) => {
            return <Row employee={employee} key={employee.id} />;
          })}
        </table>
      </EmployeeContext.Provider>
    </div>
  );
}

export default Table;
