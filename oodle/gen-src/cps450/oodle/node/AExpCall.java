/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AExpCall extends PExpCall
{
    private PExpr10 _expr10_;
    private TPeriod _period_;

    public AExpCall()
    {
        // Constructor
    }

    public AExpCall(
        @SuppressWarnings("hiding") PExpr10 _expr10_,
        @SuppressWarnings("hiding") TPeriod _period_)
    {
        // Constructor
        setExpr10(_expr10_);

        setPeriod(_period_);

    }

    @Override
    public Object clone()
    {
        return new AExpCall(
            cloneNode(this._expr10_),
            cloneNode(this._period_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpCall(this);
    }

    public PExpr10 getExpr10()
    {
        return this._expr10_;
    }

    public void setExpr10(PExpr10 node)
    {
        if(this._expr10_ != null)
        {
            this._expr10_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr10_ = node;
    }

    public TPeriod getPeriod()
    {
        return this._period_;
    }

    public void setPeriod(TPeriod node)
    {
        if(this._period_ != null)
        {
            this._period_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._period_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr10_)
            + toString(this._period_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr10_ == child)
        {
            this._expr10_ = null;
            return;
        }

        if(this._period_ == child)
        {
            this._period_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr10_ == oldChild)
        {
            setExpr10((PExpr10) newChild);
            return;
        }

        if(this._period_ == oldChild)
        {
            setPeriod((TPeriod) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
