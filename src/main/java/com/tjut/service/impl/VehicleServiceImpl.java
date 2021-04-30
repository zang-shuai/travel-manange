package com.tjut.service.impl;

import com.tjut.dao.VehicleDao;
import com.tjut.dao.VehicleService;
import com.tjut.dao.impl.VehicleDaoImpl;
import com.tjut.entity.Vehicle;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao vehicleDao = new VehicleDaoImpl();

    @Override
    public List<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicleDao.add(vehicle);
    }

    @Override
    public void delete(Integer id) {
        vehicleDao.delete(id);
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicleDao.findById(id);
    }

    @Override
    public List<Vehicle> findByPId(Integer pid) {
        return vehicleDao.findByPId(pid);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleDao.update(vehicle);
    }
}
