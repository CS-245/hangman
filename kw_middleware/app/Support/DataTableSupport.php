<?php
/* Copyright (C) KWI <http://www.kwinternational.com> */
namespace Support;


interface DataTableSupport
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
    public function makeDataTableJsonByModel($draw, $recordsTotal, $recordsFiltered, $model);
}