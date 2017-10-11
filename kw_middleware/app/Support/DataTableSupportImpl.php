<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace Support;


class DataTableSupportImpl implements DataTableSupport
{
    /**
     * Make Datatable Json array By Model
     *
     * @param int $draw Datatable page number.
     * @param int $recordsTotal Datatable view record.
     * @param int $recordsFiltered DataTable total recode.
     * @param object $model Model Object.
     * @return Json array
     */
    public function makeDataTableJsonByModel($draw, $recordsTotal, $recordsFiltered, $model)
    {
        $response = array(
            'draw' => $draw,
            'recordsTotal' => $recordsTotal,
            'recordsFiltered' => $recordsFiltered,
            'data' => $model
        );

        return $response;
    }
}