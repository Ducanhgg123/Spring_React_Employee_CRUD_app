import React, { useContext, useState } from 'react';
import { EmployeeContext } from './Table';
import { Link } from 'react-router-dom';
function Row({ employee, key }) {
  const { removeEmployee } = useContext(EmployeeContext);
  return (
    <tr>
      <td>{employee.id}</td>
      <td>{employee.firstName}</td>
      <td>{employee.lastName}</td>
      <td>{employee.email}</td>
      <td>
        <Link to={`/form/${employee.id}`}>
          <button>Edit</button>
        </Link>

        <button onClick={() => removeEmployee(employee.id)}>Delete</button>
      </td>
    </tr>
  );
}

export default Row;
