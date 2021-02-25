import React from "react";
import { connect } from "react-redux";

const City = ({ city }) => {
  return (
    <div className="city">
      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Country</th>
            <th>District</th>
            <th>Population</th>
          </tr>
        </thead>

        <tbody>
          {city.map((c, index) => (
            <tr key={c.id}>
              <td>{++index}</td>
              <td>{c.name}</td>
              <td>{c.country}</td>
              <td>{c.district}</td>
              <td>{c.population}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

const mapStateToProps = (state) => ({
  city: state.city,
});

export default connect(mapStateToProps)(City);
